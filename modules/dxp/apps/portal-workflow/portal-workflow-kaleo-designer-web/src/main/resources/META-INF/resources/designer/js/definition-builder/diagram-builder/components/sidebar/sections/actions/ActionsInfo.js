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

import ClayButton, {ClayButtonWithIcon} from '@clayui/button';
import PropTypes from 'prop-types';
import React, {useContext, useState} from 'react';

import {DiagramBuilderContext} from '../../../../DiagramBuilderContext';
import SidebarPanel from '../../SidebarPanel';
import BaseActionsInfo from '../shared-components/BaseActionsInfo';

const ActionsInfo = ({
	identifier,
	index,
	executionTypeInput = () => {
		'';
	},
	sectionsLength,
	setSections,
}) => {
	const {selectedItem, setSelectedItem} = useContext(DiagramBuilderContext);
	const {actions} = selectedItem.data;

	const [template] = useState(actions?.script?.[index]);

	const deleteSection = () => {
		setSections((prevSections) => {
			const newSections = prevSections.filter(
				(prevSection) => prevSection.identifier !== identifier
			);

			updateSelectedItem(newSections);

			return newSections;
		});
	};

	const updateActionInfo = (item) => {
		if (item.name && item.template && item.executionType) {
			setSections((prev) => {
				prev[index] = {
					...prev[index],
					...item,
				};

				updateSelectedItem(prev);

				return prev;
			});
		}
	};

	const updateSelectedItem = (values) => {
		setSelectedItem((previousItem) => ({
			...previousItem,
			data: {
				...previousItem.data,
				actions: {
					description: values.map(({description}) => description),
					executionType: values.map(
						({executionType}) => executionType
					),
					name: values.map(({name}) => name),
					priority: values.map(({priority}) => priority),
					script: values.map(({template}) => template),
					sectionsData: values.map((values) => values),
				},
			},
		}));
	};

	return (
		<SidebarPanel panelTitle={Liferay.Language.get('information')}>
			<BaseActionsInfo
				executionTypeInput={executionTypeInput}
				index={index}
				placeholderName={Liferay.Language.get('my-action')}
				placeholderTemplate="${userName} sent you a ${entryType} for review in the workflow."
				templateLabel={Liferay.Language.get('template')}
				templateLabelSecondary={Liferay.Language.get('groovy')}
				updateActionInfo={updateActionInfo}
			/>

			<div className="section-buttons-area">
				<ClayButton
					className="mr-3"
					disabled={actions?.name === '' || template === ''}
					displayType="secondary"
					onClick={() =>
						setSections((prev) => {
							return [
								...prev,
								{identifier: `${Date.now()}-${prev.length}`},
							];
						})
					}
				>
					{Liferay.Language.get('new-action')}
				</ClayButton>

				{sectionsLength > 1 && (
					<ClayButtonWithIcon
						className="delete-button"
						displayType="unstyled"
						onClick={deleteSection}
						symbol="trash"
					/>
				)}
			</div>
		</SidebarPanel>
	);
};

ActionsInfo.propTypes = {
	setContentName: PropTypes.func.isRequired,
};

export default ActionsInfo;
