package io.young.dev.catalogservice.service;

import io.young.dev.catalogservice.jpa.CatalogEntity;

public interface CatalogService {

    Iterable<CatalogEntity> getAllCatalogs();
}
