package ru.geekbrains.summer.market.ws.endpoints;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.geekbrains.summer.market.ws.services.ProductServiceSoap;
import ru.geekbrains.summer.market.ws.soap.products.GetProductByIdRequest;
import ru.geekbrains.summer.market.ws.soap.products.GetProductByIdResponse;

@Endpoint
@RequiredArgsConstructor
public class ProductEndpoint {
    private final static String NAMESPACE = "http://www.myhome.ru/geekbrains/summer/market/ws/products";
    private final ProductServiceSoap productServiceSoap;

    @PayloadRoot(namespace = NAMESPACE, localPart = "getProductByIdRequest")
    @ResponsePayload
    public GetProductByIdResponse getProductById(@RequestPayload GetProductByIdRequest request){
        GetProductByIdResponse response = new GetProductByIdResponse();
        response.setProduct(productServiceSoap.getById(request.getId()));
        return response;
    }

    //Пример запроса: POST http://localhost:8189/ws

//       <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:f="http://www.myhome.ru/geekbrains/summer/market/ws/products">
//            <soapenv:Header/>
//            <soapenv:Body>
//                <f:getAllStudentsRequest/>
//            </soapenv:Body>
//        </soapenv:Envelope>


}
