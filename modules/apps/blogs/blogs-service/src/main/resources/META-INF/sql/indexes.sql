create index IX_78BB949F on BlogsEntry (companyId, ctCollectionId);
create index IX_2CF8317D on BlogsEntry (companyId, displayDate, ctCollectionId);
create index IX_80565563 on BlogsEntry (companyId, displayDate, status, ctCollectionId);
create index IX_811D7685 on BlogsEntry (companyId, status, ctCollectionId);
create index IX_530767D9 on BlogsEntry (companyId, userId, ctCollectionId);
create index IX_DF676FBF on BlogsEntry (companyId, userId, status, ctCollectionId);
create index IX_8154EFDD on BlogsEntry (displayDate, status, ctCollectionId);
create index IX_1CA77361 on BlogsEntry (groupId, ctCollectionId);
create index IX_FDD7DDFB on BlogsEntry (groupId, displayDate, ctCollectionId);
create index IX_F678A3E1 on BlogsEntry (groupId, displayDate, status, ctCollectionId);
create index IX_816E1938 on BlogsEntry (groupId, externalReferenceCode[$COLUMN_LENGTH:75$], ctCollectionId);
create index IX_BE277347 on BlogsEntry (groupId, status, ctCollectionId);
create unique index IX_38CAA07E on BlogsEntry (groupId, urlTitle[$COLUMN_LENGTH:255$], ctCollectionId);
create index IX_141D3B01 on BlogsEntry (groupId, userId, displayDate, ctCollectionId);
create index IX_4DAB9AE7 on BlogsEntry (groupId, userId, displayDate, status, ctCollectionId);
create index IX_BC918A81 on BlogsEntry (groupId, userId, status, ctCollectionId);
create index IX_1F150819 on BlogsEntry (uuid_[$COLUMN_LENGTH:75$], companyId, ctCollectionId);
create index IX_6B6416AB on BlogsEntry (uuid_[$COLUMN_LENGTH:75$], ctCollectionId);
create unique index IX_BFDB7D5B on BlogsEntry (uuid_[$COLUMN_LENGTH:75$], groupId, ctCollectionId);