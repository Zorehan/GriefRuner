package examples;

import com.stirante.lolclient.ClientApi;
import com.stirante.lolclient.ClientConnectionListener;
import generated.LolPerksInventoryRunePageCount;
import generated.LolSummonerSummoner;

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
                    LolPerksInventoryRunePageCount runepageNumber = api.executeGet("/lol-perks/v1/currentpage", LolPerksInventoryRunePageCount.class).getResponseObject();
                    System.out.println(runepageNumber.);
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



