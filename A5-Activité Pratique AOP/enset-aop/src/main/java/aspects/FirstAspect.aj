package aspects;

public aspect FirstAspect {
    pointcut pc1(): execution(* test.Application.main(..));

//    before():pc1(){
//        System.out.println("before main ---------------------");
//    }
//    after():pc1(){
//        System.out.println("after main ---------------------");
//    }
    void around():pc1(){
        System.out.println("before ---------------------------");
        proceed();
        System.out.println("after ---------------------------");

    }
}
