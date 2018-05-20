package com.mnikiforov.solid.e_dependency_inversion.bad;

public class BadIDEResolver {

    public void bestIDE(String ideName) {
        if ("netbeans".equals(ideName)) {
            System.out.println(new BadNetbeans().netbeansName() + " is a best ideName");
        }

        if ("eclipse".equals(ideName)) {
            System.out.println(new BadEclipse().eclispeName() + " is a best ideName");
        }

        if ("idea".equals(ideName)) {
            System.out.println(new BadIdea().ideaName() + " is a best ideName");
        }
    }
}
