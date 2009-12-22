package com.fkereki.mvpproject.client.rpc;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ClientCityData
    implements IsSerializable {
  public String countryCode;
  public String regionCode;
  public String cityName;
  public String cityAccentedName;
  public int population;
  public float latitude;
  public float longitude;

  /**
   * An empty constructor method is required for serializable classes... see
   * <a>http://blog.js-development.com/2008/08/strange-gwt-compiler-error-when-
   * trying.html</a >
   * <a>http://code.google.com/p/google-web-toolkit/issues/detail?id=540</a>
   */
  public ClientCityData() {
  }

  /**
   * A standard constructor
   * 
   * @param pCC
   *          country code
   * @param pRC
   *          region code
   * @param pCN
   *          city name
   * @param pCAN
   *          city accented name
   * @param pPop
   *          population
   * @param pLat
   *          latitude
   * @param pLong
   *          longitude
   */
  public ClientCityData(
      final String pCC, final String pRC, final String pCN,
      final String pCAN, final int pPop, final float pLat,
      final float pLong) {

    countryCode= pCC;
    regionCode= pRC;
    cityName= pCN;
    cityAccentedName= pCAN;
    population= pPop;
    latitude= pLat;
    longitude= pLong;
  }

  /**
   * Perform client-side validations. The code here is limited to the GWT
   * client-side available packages.
   * 
   * @return "" if the client data is OK, or an error description otherwise
   */
  public String validationProblems() {
    if (countryCode.isEmpty()) {
      return "No country specified";
    } else if (regionCode.isEmpty()) {
      return "No region specified";
    } else if (cityName.isEmpty()) {
      return "No city name specified";
    } else if (cityAccentedName.isEmpty()) {
      return "No accented city name specified";
    } else if (population < 0) {
      return "Negative population";
    } else if (latitude < -90 || latitude > 90) {
      return "Latitude outside -90..+90";
    } else if (longitude < -180 || longitude > 180) {
      return "Longitude outside -180..+180";
    } else {
      return "";
    }
  }
}
