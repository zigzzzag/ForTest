package com.mnikiforov.advanced_java.annotations_reflection;

/**
 * Created by SBT-Nikiforov-MO on 11.08.2015.
 */
@Service(name = "VeryLazyService", lazyLoad = true)
public class LazyService {

    @Init
    public void lazyInit() throws Exception {
        System.out.println("*** run method: lazyInit(); class=" + this.getClass().getSimpleName());
    }

    public void nonInitVoid() {
    }
}
