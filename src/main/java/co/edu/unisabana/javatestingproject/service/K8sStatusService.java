package co.edu.unisabana.javatestingproject.service;

import co.edu.unisabana.javatestingproject.dto.K8sPodStatus;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.springframework.boot.SpringBootVersion;
import org.springframework.stereotype.Service;

@Service
public class K8sStatusService {

  private final String podInstanceId =
      System.getenv().getOrDefault("POD_NAME", "local-development-pod");
  private final long startTime = System.currentTimeMillis();

  private final String deployTime =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z")
          .withZone(ZoneId.systemDefault())
          .format(Instant.now());

  public K8sPodStatus getCurrentStatus() {
    long uptimeSeconds = (System.currentTimeMillis() - this.startTime) / 1000;
    String javaVersion = System.getProperty("java.version");
    String springVersion = SpringBootVersion.getVersion();

    return new K8sPodStatus(
        this.podInstanceId, uptimeSeconds, this.deployTime, javaVersion, springVersion);
  }
}
