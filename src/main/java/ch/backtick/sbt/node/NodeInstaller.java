package ch.backtick.sbt.node;

import com.github.eirslett.maven.plugins.frontend.lib.FrontendPluginFactory;
import com.github.eirslett.maven.plugins.frontend.lib.InstallationException;

import java.io.File;

/**
 * Created by AEBL001 on 21.11.2014.
 */
public class NodeInstaller {
    FrontendPluginFactory factory;

    File workingDir;

    public NodeInstaller(File workingDir, String nodeVersion, String npmVersion){
        this.workingDir = workingDir;

        this.factory = new FrontendPluginFactory(workingDir);

        try {
            this.factory.getNodeAndNPMInstaller().install(nodeVersion, npmVersion);
        } catch (InstallationException e) {
            e.printStackTrace();
        }
    }
}
