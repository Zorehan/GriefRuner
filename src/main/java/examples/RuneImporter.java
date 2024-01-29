package examples;

import com.stirante.lolclient.ClientApi;
import com.stirante.lolclient.ClientConnectionListener;
import generated.LolPerksInventoryRunePageCount;
import generated.LolPerksPerkPageResource;
import generated.LolSummonerSummoner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RuneImporter {

    public static void main(String[] args)
    {
        ClientApi api = new ClientApi();
        api.addClientConnectionListener(new ClientConnectionListener() {
            @Override
            public void onClientConnected() {
                try {
                    if (!api.isAuthorized()) {
                        return;
                    }
                    LolSummonerSummoner summoner = api.executeGet("/lol-summoner/v1/current-summoner", LolSummonerSummoner.class).getResponseObject();
                    LolPerksPerkPageResource runepageNumber = api.executeGet("/lol-perks/v1/currentpage",
                            LolPerksPerkPageResource.class).getResponseObject();
                    if(!runepageNumber.isEditable || !runepageNumber.isActive)
                    {
                        LolPerksPerkPageResource[] allPages = api.executeGet("/lol-perks/v1/pages",
                                LolPerksPerkPageResource[].class).getResponseObject();

                        List<LolPerksPerkPageResource> availablePages = Arrays.stream(allPages).filter(p -> p.isEditable).collect(Collectors.toList());
                        if(availablePages.size() > 0)
                        {
                            runepageNumber = availablePages.get(0);
                        }

                        else
                        {
                            runepageNumber = new LolPerksPerkPageResource();
                        }
                    }

                    page.
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onClientDisconnected() {
            }


        });
    }
}



