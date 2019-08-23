package com.poc.evthub.handler;

import com.amazonaws.services.lambda.runtime.events.KinesisEvent;
import com.poc.evthub.beans.ApiResponse;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class KinesisEventHandler extends SpringBootRequestHandler<KinesisEvent, ApiResponse> {

}