create index IX_6DA5084D on BatchEngineExportTask (companyId);
create index IX_DADA545C on BatchEngineExportTask (executeStatus[$COLUMN_LENGTH:75$]);
create index IX_822E7A2F on BatchEngineExportTask (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_CEAC687C on BatchEngineImportTask (companyId);
create index IX_ABC8050B on BatchEngineImportTask (executeStatus[$COLUMN_LENGTH:75$]);
create index IX_BE725720 on BatchEngineImportTask (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_863EDEA9 on BatchEngineImportTaskError (batchEngineImportTaskId);