package co.edu.unisabana.javatestingproject.view;

import co.edu.unisabana.javatestingproject.dto.K8sPodStatus;
import org.springframework.stereotype.Component;

@Component
public class HtmlDashboard {

  public String render(K8sPodStatus status) {
    return """
        <!DOCTYPE html>
        <html lang="es">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>K8s Deployment Status</title>
            <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
            <style>
                @keyframes pulse { 0%%, 100%% { opacity: 1; } 50%% { opacity: .4; } }
                .animate-pulse-fast { animation: pulse 1.5s cubic-bezier(0.4, 0, 0.6, 1) infinite; }
            </style>
        </head>
        <body class="bg-slate-950 text-slate-100 font-sans min-h-screen flex items-center justify-center p-4">
            <div class="w-full max-w-xl bg-slate-900 border border-slate-800 rounded-xl shadow-2xl overflow-hidden">
                <div class="bg-slate-950 px-6 py-4 border-b border-slate-800 flex items-center justify-between">
                    <div class="flex items-center gap-2">
                        <div class="w-3 h-3 rounded-full bg-red-500"></div>
                        <div class="w-3 h-3 rounded-full bg-yellow-500"></div>
                        <div class="w-3 h-3 rounded-full bg-green-500"></div>
                        <span class="text-xs text-slate-500 font-mono ml-2">ms-global-id-console</span>
                    </div>
                    <span class="text-xs font-mono px-2 py-1 bg-green-500/10 text-green-400 rounded border border-green-500/20 flex items-center gap-1.5">
                        <span class="w-2 h-2 rounded-full bg-green-400 block animate-pulse-fast"></span>
                        LIVE STATUS
                    </span>
                </div>

                <div class="p-6 space-y-6">
                    <div>
                        <h1 class="text-xl font-bold tracking-tight text-white flex items-center gap-2">
                            <span>☸️</span> Deployment Exitoso 2026 Junio en Kubernetes
                        </h1>
                    </div>

                    <div class="grid grid-cols-2 gap-4 font-mono text-sm">
                        <div class="bg-slate-950 p-4 rounded-lg border border-slate-800/60">
                            <span class="text-xs text-slate-500 block uppercase tracking-wider">Target Cluster</span>
                            <span class="text-emerald-400 font-semibold mt-1 block">Kubernetes (K8s)</span>
                        </div>
                        <div class="bg-slate-950 p-4 rounded-lg border border-slate-800/60">
                            <span class="text-xs text-slate-500 block uppercase tracking-wider">Pipeline Verdict</span>
                            <span class="text-blue-400 font-semibold mt-1 block">SUCCESS ✅</span>
                        </div>
                        <div class="bg-slate-950 p-4 rounded-lg border border-slate-800/60 col-span-2">
                            <span class="text-xs text-slate-500 block uppercase tracking-wider">Active K8s Pod ID</span>
                            <span class="text-yellow-400 font-semibold mt-1 block text-base select-all">%s</span>
                        </div>
                        <div class="bg-slate-950 p-4 rounded-lg border border-slate-800/60">
                            <span class="text-xs text-slate-500 block uppercase tracking-wider">Runtime Engine</span>
                            <span class="text-slate-300 mt-1 block text-xs">Java %s / Spring %s</span>
                        </div>
                        <div class="bg-slate-950 p-4 rounded-lg border border-slate-800/60">
                            <span class="text-xs text-slate-500 block uppercase tracking-wider">Pod Uptime</span>
                            <span class="text-slate-300 font-semibold mt-1 block">%s segundos</span>
                        </div>
                    </div>

                    <div class="pt-4 border-t border-slate-800/60 flex flex-col gap-1 text-xs text-slate-500 font-mono">
                        <div><span class="text-slate-400">Fecha de Despliegue:</span> %s</div>
                    </div>
                </div>
            </div>
        </body>
        </html>
        """
        .formatted(
            status.getPodInstanceId(),
            status.getJavaVersion(),
            status.getSpringVersion(),
            status.getUptimeSeconds(),
            status.getDeployTime());
  }
}
