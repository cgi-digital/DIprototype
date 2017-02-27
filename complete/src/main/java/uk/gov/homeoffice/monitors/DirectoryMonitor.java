package uk.gov.homeoffice.monitors;

import uk.gov.homeoffice.ApplicationConfiguration;
import uk.gov.homeoffice.Pipeline;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by koskinasm on 13/02/2017.
 */
public class DirectoryMonitor implements Monitor{

    private String path;

    public DirectoryMonitor(String path) throws IOException {
        this.path = path;

        Path directory = Paths.get(path);

        WatchService watchService = FileSystems.getDefault().newWatchService();

        directory.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE);

        monitor(watchService);
    }

    @Override
    public void monitor(WatchService watchService)
    {
        while(true)
        {
            try {
                final WatchKey key = watchService.poll(10, TimeUnit.SECONDS);
                if(key != null)
                {
                    for (WatchEvent<?> watchEvent : key.pollEvents()) {
                        final WatchEvent.Kind<?> kind = watchEvent.kind();
                        if((watchEvent.kind()).equals(StandardWatchEventKinds.ENTRY_CREATE))
                        {
                            System.out.println("File: " + watchEvent.context().toString() + " has been received.");

                            Pipeline pipeline = new Pipeline(ApplicationConfiguration.original_source, ApplicationConfiguration.output, ApplicationConfiguration.checks);
                            pipeline.runChecks(watchEvent.context().toString());
                        }
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
