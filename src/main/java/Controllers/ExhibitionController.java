package Controllers;

import Entities.Exhibition;
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
@RequestMapping(value = "/exhibition")
public class ExhibitionController {

    private final RestTemplate template = new RestTemplate();
    private final String address = "http://exhibitionserver:8085/exhibition/";

    public ResponseEntity<Exhibition> add(@RequestParam String name, @RequestParam int open) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", name).
                queryParam("open", open);
        HttpEntity<Exhibition> response = template.exchange(builder.toUriString(), HttpMethod.POST, null, Exhibition.class);
        return ResponseEntity.ok(response.getBody());
    }

    public ResponseEntity<Object> report(@RequestParam UUID id) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("id", id);
        HttpEntity<Object> response = template.exchange(builder.toUriString(), HttpMethod.GET, null, Object.class);
        return ResponseEntity.ok(response.getBody());
    }

    public ResponseEntity<Object> delete(@RequestParam String name) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", name);
        HttpEntity<Object> response = template.exchange(builder.toUriString(), HttpMethod.DELETE, null, Object.class);
        return ResponseEntity.ok(response.getBody());
    }


}
