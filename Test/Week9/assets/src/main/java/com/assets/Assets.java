package com.assets;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

@Entity
@Table(name = "assets")
public class Assets {

    @Id
    @Column(name = "asset_id")
    private int assetId;

    @Column(name = "asset_name")
    private String assetName;

    @Column(name = "asset_type")
    private String assetType;

    @Column(name = "assigned_employee")
    private String assignedEmployee;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "asset_status")
    private String assetStatus;

    public Assets() {
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
