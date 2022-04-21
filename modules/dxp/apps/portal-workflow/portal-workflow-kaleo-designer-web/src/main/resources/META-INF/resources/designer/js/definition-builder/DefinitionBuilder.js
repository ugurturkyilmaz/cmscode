/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 */

import React, {useState} from 'react';
import {ReactFlowProvider} from 'react-flow-renderer';

import '../../css/definition-builder/main.scss';
import {DefinitionBuilderContextProvider} from './DefinitionBuilderContext';
import DiagramBuilder from './diagram-builder/DiagramBuilder';
import {defaultNodes} from './diagram-builder/components/nodes/utils';
import UpperToolbar from './shared/components/toolbar/UpperToolbar';
import SourceBuilder from './source-builder/SourceBuilder';

export default function DefinitionBuilder(props) {
	const [active, setActive] = useState(true);
	const [blockingErrors, setBlockingErrors] = useState({errorType: ''});
	const [currentEditor, setCurrentEditor] = useState(null);
	const [definitionDescription, setDefinitionDescription] = useState('');
	const [definitionId, setDefinitionId] = useState(props.definitionName);
	const [definitionName, setDefinitionName] = useState(null);
	const [definitionTitle, setDefinitionTitle] = useState(props.title);
	const [deserialize, setDeserialize] = useState(false);
	const [elements, setElements] = useState(defaultNodes);
	const [selectedLanguageId, setSelectedLanguageId] = useState('');
	const [showInvalidContentMessage, setShowInvalidContentMessage] = useState(
		false
	);
	const [sourceView, setSourceView] = useState(false);
	const [translations, setTranslations] = useState(props.translations);
	const [version, setVersion] = useState(props.version);

	const contextProps = {
		active,
		blockingErrors,
		currentEditor,
		definitionDescription,
		definitionId,
		definitionName,
		definitionTitle,
		deserialize,
		elements,
		selectedLanguageId,
		setActive,
		setBlockingErrors,
		setCurrentEditor,
		setDefinitionDescription,
		setDefinitionId,
		setDefinitionName,
		setDefinitionTitle,
		setDeserialize,
		setElements,
		setSelectedLanguageId,
		setShowInvalidContentMessage,
		setSourceView,
		setTranslations,
		setVersion,
		showInvalidContentMessage,
		sourceView,
		translations,
		version,
	};

	return (
		<DefinitionBuilderContextProvider {...contextProps}>
			<div className="definition-builder-app">
				<ReactFlowProvider>
					<UpperToolbar {...props} />

					{sourceView ? <SourceBuilder /> : <DiagramBuilder />}
				</ReactFlowProvider>
			</div>
		</DefinitionBuilderContextProvider>
	);
}
