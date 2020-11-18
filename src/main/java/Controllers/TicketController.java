package Controllers;

import Entities.Ticket;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping(value = "/ticket")
public class TicketController {


    private final RestTemplate template = new RestTemplate();
    private final String address = "http://ticketserver:8086/ticket/";


    public ResponseEntity<Ticket> add(@RequestParam int price) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("price", price);
        HttpEntity<Ticket> response = template.exchange(builder.toUriString(), HttpMethod.POST, null, Pass.class);
        return ResponseEntity.ok(response.getBody());
    }


    public ResponseEntity<Object> report(@RequestParam UUID id) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("id", id);
        HttpEntity<Object> response = template.exchange(builder.toUriString(), HttpMethod.GET, null, Object.class);
        return ResponseEntity.ok(response.getBody());
    }



    public ResponseEntity<Object> delete(@RequestParam int price) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("price", price);
        HttpEntity<Object> response = template.exchange(builder.toUriString(), HttpMethod.DELETE, null, Object.class);
        return ResponseEntity.ok(response.getBody());
    }
}
