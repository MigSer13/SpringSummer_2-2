package ru.geekbrains.summer.market.endpoints;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.geekbrains.summer.market.services.ProductService;

@Endpoint
@RequiredArgsConstructor
public class ProductEndpoint {
    private final static String NAMESPACE = "http://www.myhome.ru/geekbrains/summer/market/products";
    private final ProductService productService;

//    @PayloadRoot(namespace = NAMESPACE, localPart = "getProductByIdRequest")
//    @ResponsePayload
//    public GetProductByIdResponse getProductById(@ResponsePayload GetProductByIdRequest request){
//        GetProductByIdResponse response = new GetProductByIdResponse();
//        response.getProduct(productService.getById(request.getId()));
//        return response;
//    }
}
