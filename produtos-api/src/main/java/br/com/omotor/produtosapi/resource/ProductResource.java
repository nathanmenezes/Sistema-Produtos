package br.com.omotor.produtosapi.resource;

import br.com.omotor.produtosapi.model.ProductDto;
import br.com.omotor.produtosapi.model.ReturnMessage;
import br.com.omotor.produtosapi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin("http://localhost:4200")
public class ProductResource {

    @Autowired
    private ProductService service;

    @PostMapping
    public DeferredResult<ResponseEntity<ReturnMessage>> save(@RequestBody @Valid ProductDto product){
        return service.save(product);
    }

    @GetMapping
    public DeferredResult<ResponseEntity<List<ProductDto>>> list(){
        return service.list();
    }

}
