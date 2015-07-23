/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.stringtest;

/**
 *
 * @author mnikiforov
 */
public class StringTest {
//    {"param0":"null","maxCountEntry":"123","remoteRegistration":"true","serviceTime":"123","inputAddress":"false","inputPhone":"false","inputSecondName":"false","htmlViewTPL":"<h4 style=\"text-align:center; margin-left:40px;\">${title}</h4> <br/><div style=\"margin-left: 30px;\"><b style=\"margin-left: 30px;\">Документы, необходимые для получения услуги:</b></p><ol><li>${param0}</li></ol>"}

    public static void main(String[] args) {

	String str = "a";
	str += "b";
	System.out.println(str);

	System.out.println(String.format("%02dд %02d:%02d:%02d",
		10,
		22,
		33,
		44));

	test2("12345678901234567890");
    }

    private static void test2(String sourceString) {
	String str = rightPad(sourceString, 30);
	System.out.println(str.length());
	System.out.println(str);
    }

    public static String leftPad(String s, int width) {
	return String.format("%" + width + "s", s);
    }

    public static String rightPad(String s, int width) {
	return String.format("%-" + width + "s", s);
    }

    private static void test1() {
	String strTest = "{\"param0\":\"null\",\"maxCountEntry\":\"123\",\"remoteRegistration\":\"true\",\"serviceTime\":\"123\",\"inputAddress\":\"false\",\"inputPhone\":\"false\",\"inputSecondName\":\"false\",\"htmlViewTPL\":\"<h4 style=\\\"text-align:center; margin-left:40px;\\\">${title}</h4> <br/><div style=\\\"margin-left: 30px;\\\"><b style=\\\"margin-left: 30px;\\\">Документы, необходимые для получения услуги:</b></p><ol><li>${param0}</li></ol>\"}";

	String str = "\"remoteRegistration\":\"true\",\"onlyThisTerminal\":\"true\",\"choiceTerminal\":\"false\",";

	String newStr = "{" + str + strTest.substring(1);
	System.out.println(newStr);
    }
}
