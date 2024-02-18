package com.emarket.catalog.tenantsetting.service;

import com.emarket.catalog.tenantsetting.model.TenantSetting;
import com.emarket.catalog.tenantsetting.repository.TenantSettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantSettingService {

    @Autowired
    private TenantSettingRepository tenantSettingRepository;

    public TenantSetting getTenantSettingById(Long id) {
        return tenantSettingRepository.findById(id).orElseThrow();
    }

    public List<TenantSetting> getTenantSettingByIds(List<Long> ids) {
        return tenantSettingRepository.findAllById(ids);
    }

    public List<TenantSetting> getAllTenantSettings() {
        return tenantSettingRepository.findAll();
    }

    public TenantSetting createTenantSetting(TenantSetting tenantSetting) {
        return tenantSettingRepository.save(tenantSetting);
    }

    public List<TenantSetting> createTenantSettings(List<TenantSetting> tenantSettings) {
        return tenantSettingRepository.saveAll(tenantSettings);
    }

    public void deleteTenantSettingById(Long id) {
        tenantSettingRepository.deleteById(id);
    }

    public void deleteAllTenantSettings() {
        tenantSettingRepository.deleteAll();
    }

    public void deleteTenantSettingsByIds(List<Long> ids) {
        tenantSettingRepository.deleteAllById(ids);
    }

}
