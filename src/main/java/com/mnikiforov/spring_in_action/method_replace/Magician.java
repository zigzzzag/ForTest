package com.mnikiforov.spring_in_action.method_replace;

/**
 * Created by zigzzzag on 14.03.16.
 */
public class Magician implements Performer {

    private MagicBox magicBox;
    private String magicWords;

    @Override
    public void perform() {
        System.out.println(magicWords);
        System.out.println("The magic box contains...");
        System.out.println(magicBox.getContents());
    }

    public void setMagicBox(MagicBox magicBox) {
        this.magicBox = magicBox;
    }

    public void setMagicWords(String magicWords) {
        this.magicWords = magicWords;
    }
}
