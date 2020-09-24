
package com.ez.classroom.jobs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class Heroku {

	@Value("${class-rooms.url}")
	private String url;

	@Value("${jobs.heroku.enable-refresh}")
	private boolean enableRefresh;

	@Scheduled(cron = "${jobs.heroku.refresh}")
	public void refresh(){
		if (enableRefresh) {
			new RestTemplate().getForEntity(url.concat("refresh"), Object.class);
		}
	}
}
