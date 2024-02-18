package com.emarket.catalog.tenantsetting.controller;

import com.emarket.catalog.tenantsetting.model.TenantSetting;
import com.emarket.catalog.tenantsetting.service.TenantSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/tenantSetting")
public class TenantSettingController {

    @Autowired
    private TenantSettingService tenantSettingService;

    @GetMapping("/all")
    public ResponseEntity<List<TenantSetting>> getAllTenantSettings() {
        return new ResponseEntity<>(tenantSettingService.getAllTenantSettings(), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<TenantSetting> getTenantSettingById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(tenantSettingService.getTenantSettingById(id), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/ids/{ids}")
    public ResponseEntity<List<TenantSetting>> getTenantSettingsByIds(@PathVariable(value = "ids") List<Long> ids) {
        return new ResponseEntity<>(tenantSettingService.getTenantSettingByIds(ids), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TenantSetting> saveTenantSetting(@RequestBody TenantSetting tenantSetting) {
        return new ResponseEntity<>(tenantSettingService.createTenantSetting(tenantSetting), HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping("/all")
    public ResponseEntity<List<TenantSetting>> saveTenantSettings(@RequestBody List<TenantSetting> tenantSettings) {
        return new ResponseEntity<>(tenantSettingService.createTenantSettings(tenantSettings), HttpStatus.OK);
    }

    @PutMapping
    @RequestMapping("/update")
    public ResponseEntity updateTenantSettings(@RequestBody TenantSetting tenantSetting) {
        try {
            tenantSettingService.getTenantSettingById(tenantSetting.getProductId());
            return new ResponseEntity<>(tenantSettingService.createTenantSetting(tenantSetting), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("TenantSetting not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    @RequestMapping("delete/all")
    public void deleteTenantSettings() {
        tenantSettingService.deleteAllTenantSettings();
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public void deleteTenantSettingById(@PathVariable(value = "id") Long id) {
        tenantSettingService.deleteTenantSettingById(id);
    }

    @DeleteMapping
    @RequestMapping("/delete/ids/{ids}")
    public void deleteTenantSettingsByIds(@PathVariable(value = "ids") List<Long> ids) {
        tenantSettingService.deleteTenantSettingsByIds(ids);
    }


}
