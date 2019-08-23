package com.poc.evthub.function;

import com.amazonaws.services.lambda.runtime.events.KinesisEvent;
import com.poc.evthub.beans.ApiResponse;
import com.poc.evthub.constant.Constants;
import com.poc.evthub.service.IngestionServiceFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Slf4j
@Component
public class KinesisEventFunction implements Function<KinesisEvent, ApiResponse> {

	//private Context context = null;

	@Autowired
	private IngestionServiceFactory ingestionServiceFactory;

//	@Autowired
//	@Qualifier("targetExecutionContext")
//	public void setContext(Context context) {
//		log.info("Context: {}", context);
//		this.context = context;
//	}

	@Override
	public ApiResponse apply(final KinesisEvent kinesisEvent) {

		log.info("KinesisEventFunction apply called...");

		String sourceDomain = System.getenv(Constants.SYSENV.SOURCE_DOMAIN);
		log.info("Source Domain = {}", sourceDomain);

		if(null == kinesisEvent || null == kinesisEvent.getRecords()) {
			log.error("Event contains no data. {}", System.lineSeparator());
			//TODO build response NOT FOUND
			return null;
		}
		else
			log.info("Received {}  records from {}. {}",
					kinesisEvent.getRecords().size(),
					kinesisEvent.getRecords().get(0).getEventSourceARN(),
					System.lineSeparator());

		log.info("ingestionServiceFactory = {}",ingestionServiceFactory);
		ingestionServiceFactory.ingest();

		return null;
	}
}
