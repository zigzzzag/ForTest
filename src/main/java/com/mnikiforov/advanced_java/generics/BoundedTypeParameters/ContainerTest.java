package com.mnikiforov.advanced_java.generics.BoundedTypeParameters;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SBT-Nikiforov-MO on 03.08.2015.
 */
public class ContainerTest {

    public static void main(String[] args) {
        Camera cameraRecurciseGenerics1 = new Camera();
        Camera cameraRecurciseGenerics2= new Camera();
        Phone phoneRecurciseGenerics1 = new Phone();
        Phone phoneRecurciseGenerics2 = new Phone();

        cameraRecurciseGenerics1.compareTo(cameraRecurciseGenerics2);
//        cameraRecurciseGenerics1.compareTo(phoneRecurciseGenerics1);//Compile error

//        Container<String> t1;//Compile Error

//        Product product1 = new Product();
//        Product product2 = new Product();
//        Product product3 = new Product();

        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        Phone phone3 = new Phone();

        Camera camera1 = new Camera();
        Camera camera2 = new Camera();
        Camera camera3 = new Camera();

//        List<Product> productList = new ArrayList<>();
        List<Phone> phoneList = new ArrayList<>();
        List<Camera> cameraList = new ArrayList<>();

//        productList.add(product1);
//        productList.add(product2);
//        productList.add(product3);
        phoneList.add(phone1);
        phoneList.add(phone2);
        phoneList.add(phone3);
        cameraList.add(camera1);
        cameraList.add(camera2);
        cameraList.add(camera3);

        List<Product> productListCopy = new ArrayList<>();
        List<Phone> phoneListCopy = new ArrayList<>();
        List<Camera> cameraListCopy = new ArrayList<>();

//        copyLists1(productList, productListCopy);
        copyLists1(phoneList, phoneListCopy);
        copyLists1(cameraList, cameraListCopy);
//        copyLists1(productList, cameraListCopy);//Compile error
//        copyLists1(cameraList, productListCopy);//Compile error

//        copyLists2(productList, productListCopy);
//        copyLists2(phoneList, phoneListCopy);//Compile error
//        copyLists2(cameraList, cameraListCopy);//Compile error
//        copyLists1(productList, cameraListCopy);//Compile error
//        copyLists1(cameraList, productListCopy);//Compile error
        copyLists2(phoneList, productListCopy);
        copyLists2(cameraList, productListCopy);
    }

    private static <T extends Product> void copyLists1(List<T> srcList, List<T> dstList) {
        dstList.clear();
        for (T product : srcList) {
            dstList.add(product);
        }
    }

    private static void copyLists2(List<? extends Product> srcList, List<? super Product> dstList) {
        dstList.clear();
        for (Product product : srcList) {
            dstList.add(product);
        }
    }
}
