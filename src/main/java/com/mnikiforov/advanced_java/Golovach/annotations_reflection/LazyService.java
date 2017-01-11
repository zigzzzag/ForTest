package com.mnikiforov.advanced_java.Golovach.annotations_reflection;

/**
 * Created by zigzzzag on 11.08.2015.
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
