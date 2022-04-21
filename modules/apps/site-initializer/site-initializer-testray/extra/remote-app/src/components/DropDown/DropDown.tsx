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

import {ClayButtonWithIcon} from '@clayui/button';
import ClayDropDown, {Align} from '@clayui/drop-down';
import React, {cloneElement, useState} from 'react';

import DropDownAction from './DropDownAction';

const {ItemList} = ClayDropDown;

type DropDownProps = {
	actions: any[];
	item: any;
	noActionsMessage?: string;
};

const DropDown: React.FC<DropDownProps> = ({
	actions,
	item,
	noActionsMessage,
}) => {
	const [active, setActive] = useState(false);

	const DropdownButton = (
		<ClayButtonWithIcon
			className="page-link"
			displayType="unstyled"
			symbol="ellipsis-v"
		/>
	);

	actions = actions.filter((action) =>
		action.show ? action.show(item) : true
	);

	if (actions.length === 0) {
		return cloneElement(DropdownButton, {
			'data-tooltip-align': 'bottom',
			'data-tooltip-delay': '200',
			'disabled': true,
			'title': noActionsMessage,
		});
	}

	return (
		<ClayDropDown
			active={active}
			alignmentPosition={Align.RightCenter}
			className="dropdown-action"
			onActiveChange={(newVal) => setActive(newVal)}
			trigger={DropdownButton}
		>
			<ItemList>
				{actions.map((action, index) => (
					<DropDownAction
						action={action}
						item={item}
						key={index}
						setActive={setActive}
					/>
				))}
			</ItemList>
		</ClayDropDown>
	);
};

export default DropDown;
