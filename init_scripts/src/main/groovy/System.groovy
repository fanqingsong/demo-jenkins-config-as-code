import jenkins.model.Jenkins
import jenkins.CLI
import org.kohsuke.stapler.StaplerProxy
import hudson.tasks.Mailer

println("-- System configuration")

// TODO: Configure Job Restrictions, Script Security, Authorize Project, etc., etc.
println("--- Configuring Remoting (JNLP4, no Remoting CLI)")
CLI.get().setEnabled(false);
Jenkins.instance.setAgentProtocols(new HashSet<String>(Arrays.asList("JNLP4-connect")));
Jenkins.instance.getExtensionList(StaplerProxy.class)
        .get(jenkins.security.s2m.AdminWhitelistRule.class)
        .setMasterKillSwitch(false)


println("--- Configuring Email global settings")
jenkins.model.JenkinsLocationConfiguration.get().setAdminAddress("admin@non.existent.email")
Mailer.descriptor().setDefaultSuffix("@non.existent.email")
