package com.emarket.catalog.tenantsetting.repository;

import com.emarket.catalog.tenantsetting.model.TenantSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantSettingRepository extends JpaRepository<TenantSetting, Long> {


}
