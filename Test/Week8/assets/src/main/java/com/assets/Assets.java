
package com.assets;

public class Assets {

    private int assetId;
    private String assetName;
    private String assetType;
    private String assignedEmployee;
    private String serialNumber;
    private String assetStatus;

    public Assets(int assetId, String assetName, String assetType, String assignedEmployee, String serialNumber, String assetStatus) {
    this.assetId = assetId;
    this.assetName = assetName;
    this.assetType = assetType;
    this.assignedEmployee = assignedEmployee;
    this.serialNumber = serialNumber;
    this.assetStatus = assetStatus;
}

    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getAssignedEmployee() {
        return assignedEmployee;
    }

    public void setAssignedEmployee(String assignedEmployee) {
        this.assignedEmployee = assignedEmployee;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(String assetStatus) {
        this.assetStatus = assetStatus;
    }
}
