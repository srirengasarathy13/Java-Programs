
package com.assets;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AssetsService {

    private final List<Assets> assets = new ArrayList<>();

    public AssetsService() {
        assets.add(new Assets(101, "Dell Laptop", "Laptop", "Sri", "DELL12345", "Assigned"));

        assets.add(new Assets(102, "HP Monitor", "Monitor", "Sarathy", "HP12345", "Available"));
    }

    public List<Assets> getAllAssets() {
        return assets;
    }

    public Assets getAssetById(int assetId) {
        for (Assets asset : assets) {
            if (asset.getAssetId() == assetId) {
                return asset;
            }
        }
        return null;
    }

    public String createAsset(Assets asset) {
        if (getAssetById(asset.getAssetId()) != null) {
            return "Asset ID " + asset.getAssetId() + " already exists!";
        }

        assets.add(asset);
        return "Asset " + asset.getAssetId() + " created successfully!";
    }

    public Assets updateAsset(int assetId, Assets updatedAsset) {
        for (int i = 0; i < assets.size(); i++) {
            Assets asset = assets.get(i);

            if (asset.getAssetId() == assetId) {
                updatedAsset.setAssetId(assetId);
                assets.set(i, updatedAsset);
                return updatedAsset;
            }
        }

        System.out.println("Asset ID : " + assetId + " not found!");
        return null;
    }

    public boolean deleteAsset(int assetId) {
        return assets.removeIf(
                asset -> asset.getAssetId() == assetId);
    }
}
