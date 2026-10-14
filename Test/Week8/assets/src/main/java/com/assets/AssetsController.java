
package com.assets;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getAssetById(@PathVariable int assetId) {
        Assets asset = assetsService.getAssetById(assetId);

        if (asset == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Asset " + assetId + " not found!");
        }

        return ResponseEntity.ok(asset);
    }

    @PostMapping
    public ResponseEntity<?> createAsset(@RequestBody Assets asset) {
        String result = assetsService.createAsset(asset);

        if (result.contains("already exists")) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{assetId}")
    public ResponseEntity<?> updateAsset(
            @PathVariable int assetId,
            @RequestBody Assets updatedAsset) {

        Assets asset = assetsService.updateAsset(assetId, updatedAsset);

        if (asset == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Asset " + assetId + " not found!");
        }

        return ResponseEntity.ok(asset);
    }

    @DeleteMapping("/{assetId}")
    public ResponseEntity<String> deleteAsset(@PathVariable int assetId) {
        boolean deleted = assetsService.deleteAsset(assetId);

        if (deleted) {
            return ResponseEntity.ok(
                    "Asset " + assetId + " deleted successfully!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Asset " + assetId + " not found!");
    }
}
