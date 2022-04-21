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

import ClayForm, {ClayInput, ClaySelect} from '@clayui/form';
import ClayIcon from '@clayui/icon';
import PropTypes from 'prop-types';
import React, {useContext, useEffect, useState} from 'react';

import {DiagramBuilderContext} from '../../../../DiagramBuilderContext';
import {limitValue, sortElements} from '../utils';

const DEFAULT_LIMIT = 1;
const MIN_PRIORITY = 1;

let executionTypeOptions = [
	{
		label: Liferay.Language.get('on-entry'),
		value: 'onEntry',
	},
	{
		label: Liferay.Language.get('on-exit'),
		value: 'onExit',
	},
];

const BaseActionsInfo = ({
	executionTypeInput,
	index,
	placeholderName,
	placeholderTemplate,
	templateLabel,
	templateLabelSecondary,
	updateActionInfo,
}) => {
	const {selectedItem} = useContext(DiagramBuilderContext);

	const {actions} = selectedItem.data;

	const [description, setDescription] = useState(
		actions?.description?.[index]
	);
	const [executionType, setExecutionType] = useState(
		actions?.executionType?.[index] ?? executionTypeOptions[0].value
	);
	const [name, setName] = useState(actions?.name?.[index]);
	const [priority, setPriority] = useState(actions?.priority?.[index]);
	const [template, setTemplate] = useState(actions?.script?.[index]);

	useEffect(() => {
		if (
			selectedItem.type === 'task' &&
			!executionTypeOptions
				.map((option) => option.value)
				.includes('onAssignment')
		) {
			executionTypeOptions.push({
				label: Liferay.Language.get('on-assignment'),
				value: 'onAssignment',
			});
		}

		sortElements(executionTypeOptions, 'value');

		return function cleanup() {
			executionTypeOptions = executionTypeOptions.filter(({value}) => {
				return value !== 'onAssignment';
			});
		};
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, []);

	return (
		<>
			<ClayForm.Group>
				<label htmlFor="name">
					{Liferay.Language.get('name')}

					<span className="ml-1 mr-1 text-warning">*</span>
				</label>

				<ClayInput
					id="name"
					onBlur={() =>
						updateActionInfo({
							description,
							executionType,
							name,
							priority,
							template,
						})
					}
					onChange={({target}) => {
						setName(target.value);
					}}
					placeholder={placeholderName}
					type="text"
					value={name}
				/>
			</ClayForm.Group>
			<ClayForm.Group>
				<label htmlFor="description">
					{Liferay.Language.get('description')}
				</label>

				<ClayInput
					id="description"
					onBlur={() =>
						updateActionInfo({
							description,
							executionType,
							name,
							priority,
							template,
						})
					}
					onChange={({target}) => {
						setDescription(target.value);
					}}
					type="text"
					value={description}
				/>
			</ClayForm.Group>
			<ClayForm.Group>
				<label htmlFor="template">
					{`${templateLabel} (${templateLabelSecondary})`}

					<span className="ml-1 mr-1 text-warning">*</span>
				</label>

				<ClayInput
					component="textarea"
					id="template"
					onBlur={() =>
						updateActionInfo({
							description,
							executionType,
							name,
							priority,
							template,
						})
					}
					onChange={({target}) => {
						setTemplate(target.value);
					}}
					placeholder={placeholderTemplate}
					type="text"
					value={template}
				/>
			</ClayForm.Group>

			{typeof executionTypeInput !== 'undefined' && (
				<ClayForm.Group>
					<label htmlFor="execution-type">
						{Liferay.Language.get('execution-type')}
					</label>

					<ClaySelect
						aria-label="Select"
						id="execution-type"
						onChange={({target}) => {
							setExecutionType(target.value);
						}}
						onClickCapture={() =>
							updateActionInfo({
								description,
								executionType,
								name,
								priority,
								template,
							})
						}
					>
						{executionTypeOptions.map((item) => (
							<ClaySelect.Option
								key={item.value}
								label={item.label}
								selected={item.value === executionType}
								value={item.value}
							/>
						))}
					</ClaySelect>
				</ClayForm.Group>
			)}

			<ClayForm.Group>
				<label htmlFor="priority">
					{Liferay.Language.get('priority')}
				</label>

				<span
					className="ml-1"
					title={Liferay.Language.get('label-name')}
				>
					<ClayIcon
						className="text-muted"
						symbol="question-circle-full"
					/>
				</span>

				<ClayInput
					aria-label="Select"
					id="priority"
					min={MIN_PRIORITY}
					onBlur={({target}) => {
						let {value: newValue} = target;

						newValue = limitValue({
							defaultValue: DEFAULT_LIMIT,
							min: MIN_PRIORITY,
							value: newValue,
						});

						setPriority(newValue);

						updateActionInfo({
							description,
							executionType,
							name,
							priority,
							template,
						});
					}}
					onChange={({target}) => {
						let {value: newValue} = target;
						newValue = newValue.includes('-')
							? newValue.replace('-', '')
							: newValue;

						setPriority(newValue);
					}}
					type="number"
					value={priority}
				/>
			</ClayForm.Group>
			<div className="sheet-subtitle" />
		</>
	);
};

BaseActionsInfo.propTypes = {
	executionTypeInput: PropTypes.func,
	index: PropTypes.number,
	placeholderName: PropTypes.string,
	placeholderTemplate: PropTypes.string,
	templateLabel: PropTypes.string,
	templateLabelSecondary: PropTypes.string,
	updateActionInfo: PropTypes.func,
};

export default BaseActionsInfo;
