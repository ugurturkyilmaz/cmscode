/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

import {useMutation, useQuery} from '@apollo/client';
import ClayButton from '@clayui/button';
import ClayForm, {ClaySelectWithOption} from '@clayui/form';
import ClayLayout from '@clayui/layout';
import classNames from 'classnames';
import {useState} from 'react';

import Input from '../../../components/Input';
import Container from '../../../components/Layout/Container';
import MarkdownPreview from '../../../components/Markdown';
import Modal from '../../../components/Modal';
import {CreateRequirement} from '../../../graphql/mutations';
import {
	CTypePagination,
	TestrayComponent,
	getComponents,
} from '../../../graphql/queries';
import {FormModalOptions} from '../../../hooks/useFormModal';
import i18n from '../../../i18n';

const requirementFormDefault = {
	components: '',
	description: '',
	descriptionType: '',
	key: '',
	linkTitle: '',
	linkURL: '',
	summary: '',
};

type RequirementsForm = typeof requirementFormDefault;

const descriptionTypes = [
	{
		label: 'Markdown',
		value: 'markdown',
	},
	{
		label: 'Plain Text',
		value: 'plaintext',
	},
];

const FormRow: React.FC<{title: string}> = ({children, title}) => (
	<>
		<ClayLayout.Row justify="start">
			<ClayLayout.Col size={3} sm={12} xl={3}>
				<h5 className="font-weight-normal">{title}</h5>
			</ClayLayout.Col>

			<ClayLayout.Col size={3} sm={12} xl={9}>
				{children}
			</ClayLayout.Col>
		</ClayLayout.Row>

		<hr />
	</>
);

type RequirementsFormProps = {
	form: RequirementsForm;
	onChange: (event: any) => void;
	testrayComponents: TestrayComponent[];
};
const RequirementsForm: React.FC<RequirementsFormProps> = ({
	form,
	onChange,
	testrayComponents,
}) => {
	return (
		<Container>
			<ClayForm>
				<ClayLayout.Row justify="center">
					<ClayLayout.Col size={3} sm={12} xl={3}>
						{i18n.translate('requirements')}
					</ClayLayout.Col>

					<ClayLayout.Col size={3} sm={12} xl={9}>
						<ClayForm.Group className="form-group-sm">
							<Input
								label={i18n.translate('key')}
								name="key"
								onChange={onChange}
								required
								value={form.key}
							/>

							<Input
								label={i18n.translate('summary')}
								name="summary"
								onChange={onChange}
								required
								value={form.summary}
							/>

							<Input
								label={i18n.translate('link-url')}
								name="linkURL"
								onChange={onChange}
								required
								value={form.linkURL}
							/>

							<Input
								label={i18n.translate('link-title')}
								name="linkTitle"
								onChange={onChange}
								required
								value={form.linkTitle}
							/>

							<label
								className={classNames(
									'font-weight-normal mx-0 mt-2 text-paragraph'
								)}
							>
								{i18n.translate('main-component')}
							</label>

							<ClaySelectWithOption
								className="rounded-xs"
								name="components"
								onChange={onChange}
								options={testrayComponents.map(
									({id, name}) => ({
										label: name,
										value: id,
									})
								)}
								required
								value={form.components}
							/>
						</ClayForm.Group>
					</ClayLayout.Col>
				</ClayLayout.Row>

				<hr />

				<FormRow title={i18n.translate('description')}>
					<ClayForm.Group className="form-group-sm">
						<ClaySelectWithOption
							className="mb-2 rounded-xs"
							name="descriptionType"
							onChange={onChange}
							options={descriptionTypes}
							value={form.descriptionType}
						/>

						<Input
							name="description"
							onChange={onChange}
							required
							type="textarea"
							value={form.description}
						/>
					</ClayForm.Group>

					<MarkdownPreview markdown={form.description} />
				</FormRow>
			</ClayForm>
		</Container>
	);
};

type RequirementsModalProps = {
	modal: FormModalOptions;
};

const RequirementsModal: React.FC<RequirementsModalProps> = ({
	modal: {observer, onClose, onError, onSave, visible},
}) => {
	const [form, setForm] = useState<RequirementsForm>(requirementFormDefault);

	const [onCreateRequirement] = useMutation(CreateRequirement);

	const {data: testrayComponentsData} = useQuery<
		CTypePagination<'components', TestrayComponent>
	>(getComponents);

	function onchange({target}: any): void {
		const {name, value} = target;

		setForm({
			...form,
			[name]: value,
		});
	}

	const testrayComponents = testrayComponentsData?.c?.components.items || [];

	const onSubmit = async () => {
		const newForm: RequirementsForm = {
			...form,
			components: form.components,
			description: form.description,
			descriptionType: form.descriptionType,
			key: form.key,
			linkTitle: form.linkTitle,
			linkURL: form.linkURL,
			summary: form.summary,
		};

		try {
			await onCreateRequirement({
				variables: {
					TestrayRequirement: newForm,
				},
			});

			onSave();
		}
		catch (error) {
			onError();
		}
	};

	return (
		<Modal
			last={
				<ClayButton.Group spaced>
					<ClayButton displayType="secondary" onClick={onClose}>
						{i18n.translate('close')}
					</ClayButton>

					<ClayButton displayType="primary" onClick={onSubmit}>
						{i18n.translate('add-requirements')}
					</ClayButton>
				</ClayButton.Group>
			}
			observer={observer}
			size="full-screen"
			title={i18n.translate('new-requirements')}
			visible={visible}
		>
			<RequirementsForm
				form={form}
				onChange={onchange}
				testrayComponents={testrayComponents}
			/>
		</Modal>
	);
};

export default RequirementsModal;
