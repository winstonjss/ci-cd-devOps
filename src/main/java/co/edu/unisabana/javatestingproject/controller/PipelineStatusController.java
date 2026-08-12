package co.edu.unisabana.javatestingproject.controller;

import co.edu.unisabana.javatestingproject.dto.K8sPodStatus;
import co.edu.unisabana.javatestingproject.service.K8sStatusService;
import co.edu.unisabana.javatestingproject.view.HtmlDashboard;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hello")
public class PipelineStatusController {

  private final K8sStatusService statusService;
  private final HtmlDashboard dashboardPresenter;

  @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
  public String getStatusDashboard() {
    K8sPodStatus status = statusService.getCurrentStatus();

    return dashboardPresenter.render(status);
  }
}
