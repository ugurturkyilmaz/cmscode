create table Marketplace_App (
	uuid_ VARCHAR(75) null,
	appId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	remoteAppId LONG,
	title VARCHAR(255) null,
	description STRING null,
	category VARCHAR(255) null,
	iconURL STRING null,
	version VARCHAR(75) null,
	required BOOLEAN
);

create table Marketplace_Module (
	uuid_ VARCHAR(75) null,
	moduleId LONG not null primary key,
	companyId LONG,
	appId LONG,
	bundleSymbolicName VARCHAR(500) null,
	bundleVersion VARCHAR(75) null,
	contextName VARCHAR(75) null
);