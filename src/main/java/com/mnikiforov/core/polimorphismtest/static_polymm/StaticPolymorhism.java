package com.mnikiforov.core.polimorphismtest.static_polymm;

/**
 * Created by sbt-nikiforov-mo on 16.06.16.
 */
public class StaticPolymorhism {

    public static void main(String[] args) {
        StaticChild child = new StaticChild();
        child.m();

        StaticParent parent = new StaticParent();
        parent.m();

        StaticParent cParent = new StaticChild();
        cParent.m();

        StaticBaby baby = new StaticBaby();
        baby.m();
    }
}
