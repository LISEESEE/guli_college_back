package com.lss.study.concurrent02.c11;

public class ActionContext {
    private static final ThreadLocal<Context> threadLocal = ThreadLocal.withInitial(Context::new);

    private static class ContextHolder{
        private static ActionContext actionContext = new ActionContext();
    }
    public static ActionContext getActionContext(){
        return ContextHolder.actionContext;
    }
    public Context getContext(){
        return threadLocal.get();
    }

    public ActionContext() {

    }
}
