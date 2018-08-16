package tools;



import java.lang.reflect.Proxy;

import model.api.IHttpService;
import model.http.HttpCheckProxyGetInvocation;
import model.http.HttpCheckProxyInvocation;
import model.http.HttpProxyInvocation;
import model.http.HttpProxyNoDialogInvocation;


public class ProxyUtils {
    private static HttpProxyInvocation proxyHandler = new HttpProxyInvocation();
    private static HttpCheckProxyInvocation proxycheckHandler = new HttpCheckProxyInvocation();
    private static HttpCheckProxyGetInvocation proxycheckgetHandler = new HttpCheckProxyGetInvocation();
    private static HttpProxyNoDialogInvocation proxyHandlerNoDialog = new HttpProxyNoDialogInvocation();
    public static IHttpService getHttpProxyNoDialog() {
        return (IHttpService) Proxy.newProxyInstance(proxyHandlerNoDialog.getClass().getClassLoader(), new Class[]{IHttpService.class}, proxyHandlerNoDialog);
    }
    public static IHttpService getHttpProxy() {
        return (IHttpService) Proxy.newProxyInstance(proxyHandler.getClass().getClassLoader(), new Class[]{IHttpService.class}, proxyHandler);
    }
    public static IHttpService PostHttpCheckProxy() {
        return (IHttpService) Proxy.newProxyInstance(proxycheckHandler.getClass().getClassLoader(), new Class[]{IHttpService.class}, proxycheckHandler);
    }
    public static IHttpService GetHttpCheckProxy() {
        return (IHttpService) Proxy.newProxyInstance(proxycheckgetHandler.getClass().getClassLoader(), new Class[]{IHttpService.class}, proxycheckgetHandler);
    }
}
