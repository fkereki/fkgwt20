/****************************************************************************

    Virtual nixie tube display, clock & calculator DHTML components

    v 1.05, 20080214

    (c) 2007-08 Cestmir Hybl, cestmir.hybl@nustep.net
    http://cestmir.freeside.sk/projects/dhtml-nixie-display

    license: free for non-commercial use, copyright must be preserved

 ****************************************************************************/

/*   NixieDisplay   */

// public class NixieDisplay
function NixieDisplay() {
  // public
  this.id = 'nixiedefault';
  this.elContainer = null;
  this.charCount = 10;
  this.autoDecimalPoint = true; // automatically extracts decimal point index in setText() call
  this.align = 'left';			 // alignment of text via setText() call
  this.afterUpdate = null;		 // after display update callback

  this.charWidth = 62;
  this.charHeight = 150;
  this.charGapWidth = 0;
  this.extraGapsWidths = [];
  this.createCharElements = true;

  this.text = '';
  this.decimalPoint = -1;

  this.urlCharsetImage = 'nixie/zm1082_l1_09bdm_62x150_8b.png';
  this.charMap = {
      0: 0,   1: 1,   2: 2,   3: 3,   4: 4,   5: 5,   6: 6,   7: 7,   8: 8,   9: 9,
    '0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9, ' ': 10, '-': 11,
    'default': 10
  };
    // maps displayable chars onto glyph matrix indexes

  // protected
  function _drawChar(index) {
    var el = document.getElementById(this.id + '_d' + index);
    var charIndex = this.charMap[this.text.charAt(index)];
    if (!charIndex && charIndex !== 0)
      charIndex = this.charMap['default'];
    var x = - (charIndex * this.charWidth);
    var y = (index === this.decimalPoint ? - this.charHeight : 0);
    el.style.backgroundPosition = x + 'px ' + y + 'px';
  }
  this._drawChar = _drawChar;

  // Shows given string on display
  // public
  function setText(text, updateDecimalPoint) {
    // force string type
    this.text = text + '';

    // extract decimal point
    updateDecimalPoint = (typeof(updateDecimalPoint) != 'undefined' ? updateDecimalPoint : this.autoDecimalPoint);
    if (updateDecimalPoint) {
      var i = this.text.indexOf('.');
      if (i >= 0) {
        this.decimalPoint = i - 1;
        // alert(this.decimalPoint);
        this.text = this.text.substr(0, i) + this.text.substr(i + 1);
      } else
        this.decimalPoint = -1;
    }

    // pad up to display width (from left/right acording to this.align)
    if (this.text.length < this.charCount) {
      var pad = '';
      var padWidth = this.charCount - this.text.length;
      for (var i = 0; i < padWidth; i++)
        pad += ' ';
      if (this.align == 'left')
        this.text = this.text + pad;
      else {
        if (this.decimalPoint >= 0)
          this.decimalPoint += padWidth;
        this.text = pad + this.text;
      }
    }

    if (this.text.length > this.charCount)
      this.text = this.text.substr(0, this.charCount);

    // draw chars
    for (var i = 0; i < this.text.length; i++) {
      this._drawChar(i);
    }

    if (this.afterUpdate)
      this.afterUpdate(this);
  }
  this.setText = setText;

  // Sets char at given display position
  // public
  function setChar(index, chr)
  {
    // alert(chr);
    this.text = this.text.substring(0, index) + chr + this.text.substring(index + 1);
    this.setText(this.text, false);
  }
  this.setChar = setChar;

  function setDecimalPoint(index)
  {
    var oldDecimalPoint = this.decimalPoint;
    this.decimalPoint = ((!index && index !== 0) ? -1 : index);
    if (oldDecimalPoint != this.decimalPoint) {
      if (oldDecimalPoint >= 0)
        this._drawChar(oldDecimalPoint);
      if (this.decimalPoint >= 0)
        this._drawChar(this.decimalPoint);
    }
  }
  this.setDecimalPoint = setDecimalPoint;

  // Clears display - fills all positions with given char (space by default).
  // public
  function clear(chr)
  {
    chr = (typeof(chr) == 'undefined' ? ' ' : chr);
    this.text = '';
    for (var i = 0; i < this.charCount; i++)
      this.text += chr;
    this.decimalPoint = -1;
    this.setText(this.text);
  }
  this.clear = clear;

  // Shifts display contents left or right
  // public
  function shift(direction, step)
  {
    step = (!step && step !== 0 ? 1 : step);
    direction = (!direction ? 'left' : direction);

    if (this.decimalPoint >= 0) {
      this.decimalPoint += (direction == 'left' ? - step : + step);
      if (this.decimalPoint >= this.charCount)
        this.decimalPoint = -1;
    }

    if (direction == 'left')
      this.text = this.text.substr(step) + ' '; // @todo padding for step != +/-1
    else if (direction == 'right')
      this.text = ' ' + this.text.substr(0, this.text.length - 1); // @todo padding for step != +/-1
    this.setText(this.text, false);
  }
  this.shift = shift;

  // public
  function init()
  {
    if (!this.elContainer) {
      this.elContainer = document.getElementById(this.id);
      if (!this.elContainer) { 
        throw "Container element '" + this.id + "' not found";
      }
    }
    this.elContainer.style.position = 'relative';

    if (this.createCharElements) {
      var totalWidth = 0;
      for (var i = 0; i < this.charCount; i++) {
        var charWidthIncludingGap = (this.charWidth + this.charGapWidth);

        var elId = this.id + '_d' + i;
        var el0 = document.getElementById(elId);
        var el = (el0 ? el0 : document.createElement('div'));
        el.id = this.id + '_d' + i;
        el.className = 'digit d' + i;
        el.style.position = 'absolute';
        el.style.left = totalWidth + 'px';
        el.style.width = this.charWidth + 'px';
        el.style.height = this.charHeight + 'px';
        el.style.background = 'url(' + this.urlCharsetImage + ')';
        if (!el.parentNode)
          this.elContainer.appendChild(el);

        totalWidth += charWidthIncludingGap + (this.extraGapsWidths[i] ? this.extraGapsWidths[i] : 0);
      }
      this.elContainer.style.width = totalWidth + 'px';
      this.elContainer.style.height = this.charHeight + 'px';
    }

    if (this.text)
      this.setText(this.text)
    else
      this.clear();
  }
  this.init = init;
}
