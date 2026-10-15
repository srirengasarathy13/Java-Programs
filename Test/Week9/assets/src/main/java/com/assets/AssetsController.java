package com.assets;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assets")
public class AssetsController {

    private final AssetsService assetsService;

    public AssetsController(AssetsService assetsService) {
        this.assetsService = assetsService;
    }

    @GetMapping
    public List<Assets> getAssets() {
        return assetsService.getAllAssets();
    }

    @GetMapping("/{assetId}")
    public Assets getAssetById(@PathVariable int assetId) {
        return assetsService.getAssetById(assetId);
    }

    @PostMapping
    public Assets createAsset(@RequestBody Assets asset) {
        return assetsService.createAsset(asset);
    }

    @PutMapping("/{assetId}")
    public Assets updateAsset(@PathVariable int assetId,
                              @RequestBody Assets updatedAsset) {
        return assetsService.updateAsset(assetId, updatedAsset);
    }

    @DeleteMapping("/{assetId}")
    public String deleteAsset(@PathVariable int assetId) {
        boolean deleted = assetsService.deleteAsset(assetId);
        if (deleted) {
            return "Asset " + assetId + " deleted successfully!";
        }
        return "Asset " + assetId + " not found!";
    }
}
