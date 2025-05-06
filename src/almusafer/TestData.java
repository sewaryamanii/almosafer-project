package almusafer;

import java.util.Random;

public class TestData {
String expectedlanguage ="en";
String expectednumber ="+96655440000";
String expectedcurrency = "SAR";
String [] cityen = {"dubai" , "jeddah", "riyadh"};
String [] cityar = { "دبي","الرياض","جدة"};

Random rand = new Random();


int randomcityen = rand.nextInt(cityen.length);
int randomcityar = rand.nextInt(cityar.length);
String[] adultsnumber = {"1 Room, 2 Adults, 0 Children","1 Room, 1 Adult, 0 Children"};
String[] options = { "A", "B" };
int randomnuber = rand.nextInt(options.length);



}
