package com.dankai.latte.net.rx;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.net
 *  文件名:    RestClient
 *  创建者:    WK
 *  时间：     2019/7/13 20:46
 *  描述：     TODO
 */

public class RxRestClient {

//    private final String URL;
//    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
//    private final RequestBody BODY;
//    private LoaderStyle LOADER_STYLE;
//    private final File FILE;
//    private final Context CONTEXT;
//
//    public RxRestClient(String url,
//                        Map<String, Object> params,
//                        RequestBody body,
//                        Context context,
//                        LoaderStyle loaderStyle,
//                        File file
//    ) {
//        this.URL = url;
//        PARAMS.putAll(params);
//        this.BODY = body;
//        this.CONTEXT = context;
//        this.LOADER_STYLE = loaderStyle;
//        this.FILE = file;
//    }
//
//    public static RxRestClientBuilder builder() {
//        return new RxRestClientBuilder();
//    }
//
//    private Observable<String> request(HttpMethod method) {
//        final RxRestService service = RestCreator.getRxRestService();
//        Observable<String> observable = null;
//
//        if (LOADER_STYLE != null) {
//            LatteLoader.showLoading(CONTEXT, LOADER_STYLE);
//        }
//        switch (method) {
//            case GET:
//                observable = service.get(URL, PARAMS);
//                break;
//            case POST:
//                observable = service.post(URL, PARAMS);
//                break;
//            case POST_RAW:
//                observable = service.postRaw(URL, BODY);
//                break;
//            case PUT:
//                observable = service.put(URL, PARAMS);
//                break;
//            case PUT_RAW:
//                observable = service.putRaw(URL, BODY);
//                break;
//            case DELETE:
//                observable = service.delete(URL, PARAMS);
//                break;
//            case UPLOAD:
//                final RequestBody requestBody =
//                        RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), FILE);
//                final MultipartBody.Part body =
//                        MultipartBody.Part.createFormData("file", FILE.getName(), requestBody);
//                observable = service.upload(URL, body);
//                break;
//            default:
//                break;
//        }
//        return observable;
//    }
//
//    public final Observable<String> get() {
//        return request(HttpMethod.GET);
//    }
//
//    public final Observable<String> post() {
//        if (BODY == null) {
//            return request(HttpMethod.POST);
//        } else {
//            if (!PARAMS.isEmpty()) {
//                throw new RuntimeException("params must be null!");
//            }
//            return request(HttpMethod.POST_RAW);
//        }
//    }
//
//    public final Observable<String> put() {
//        if (BODY == null) {
//            return request(HttpMethod.PUT);
//        } else {
//            if (!PARAMS.isEmpty()) {
//                throw new RuntimeException("params must be null!");
//            }
//            return request(HttpMethod.PUT_RAW);
//        }
//    }
//
//    public final Observable<String> delete() {
//        return request(HttpMethod.DELETE);
//    }
//
//    public final Observable<ResponseBody> download() {
//        return RestCreator.getRxRestService().download(URL, PARAMS);
//    }
}
