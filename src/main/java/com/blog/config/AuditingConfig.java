package com.blog.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author devmwpark[devmwpark@gmail.com]
 */

@EnableAsync
@SpringBootApplication
@EnableJpaAuditing
public class AuditingConfig {
}
