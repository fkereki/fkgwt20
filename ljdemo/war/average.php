<?php
if (!isset($_REQUEST['first']) || !isset($_REQUEST['second']) || !isset($_REQUEST['third'])) {
	header('HTTP/1.0 400 Missing parameters');
} else {
	$first = $_REQUEST['first'];
	$second = $_REQUEST['second'];
	$third = $_REQUEST['third'];

	if (empty($first) || empty($second) || empty($third)) {
		header('HTTP/1.0 400 Empty parameters');
	} else {
		$average = ($first + $second + $third) / 3 ;
		echo $average;
	}
}
