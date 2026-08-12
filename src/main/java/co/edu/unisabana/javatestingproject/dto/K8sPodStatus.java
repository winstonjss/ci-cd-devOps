package co.edu.unisabana.javatestingproject.dto;

import lombok.Value;

@Value
public class K8sPodStatus {
  String podInstanceId;
  long uptimeSeconds;
  String deployTime;
  String javaVersion;
  String springVersion;
}
