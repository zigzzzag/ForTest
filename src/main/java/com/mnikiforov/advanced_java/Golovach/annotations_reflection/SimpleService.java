package com.mnikiforov.advanced_java.Golovach.annotations_reflection;

/**
 * Created by SBT-Nikiforov-MO on 11.08.2015.
 */
@Service(name = "SuperSimpleService")
public class SimpleService {

    @Init(suppressException = true)
    public void initService() {
        System.out.println("*** run method: initSetvise(); class=" + this.getClass().getSimpleName());
    }

    public void nonInitVoid() {
    }
}
