package com.assets;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AssetsService {

    private final AssetsRepository assetRepository;

    public AssetsService(AssetsRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public List<Assets> getAllAssets() {
        return assetRepository.findAll();
    }

    public Assets getAssetById(int assetId) {
        return assetRepository.findById(assetId).orElse(null);
    }

    public Assets createAsset(Assets asset) {
        return assetRepository.save(asset);
    }

    public Assets updateAsset(int assetId, Assets updatedAsset) {
    for (Assets asset : assetRepository.findAll()) {
        if (asset.getAssetId() == assetId) {
            asset.setAssetName(updatedAsset.getAssetName());
            asset.setAssetType(updatedAsset.getAssetType());
            asset.setAssignedEmployee(updatedAsset.getAssignedEmployee());
            asset.setSerialNumber(updatedAsset.getSerialNumber());
            asset.setAssetStatus(updatedAsset.getAssetStatus());
            return assetRepository.save(asset);
        }
    }

    System.out.println("Asset ID : " + assetId + " not found!");
    return null;
}

    public boolean deleteAsset(int assetId) {
        if (assetRepository.existsById(assetId)) {
            assetRepository.deleteById(assetId);
            return true;
        }

        return false;
    }
}