package com.poc.evthub.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApiResponse {

    private static final ObjectMapper mapper = new ObjectMapper ();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty
    private Integer status = HttpStatus.OK.value();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty
    private String responseCode = null;

    @JsonProperty
    private String time = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(new Date());

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty
    private volatile Map<String, String> header;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty
    private ObjectNode data = mapper.createObjectNode();
}
