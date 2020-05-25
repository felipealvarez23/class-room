
package com.ez.classroom.jobs;


import com.ez.classroom.delegates.NextClassDelegate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Notificacion {

	private NextClassDelegate nextClassDelegate;

	@Autowired
	public Notificacion(NextClassDelegate nextClassDelegate) {
		this.nextClassDelegate = nextClassDelegate;
	}

	@Scheduled(cron = "${jobs.next-class}")
	public void test(){
		nextClassDelegate.checkNextClass();
		log.info("Next class job executed");
	}

}
