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

import ClayAlert from '@clayui/alert';
import ClayButton from '@clayui/button';
import ClayIcon from '@clayui/icon';
import classNames from 'classnames';
import PropTypes from 'prop-types';
import React from 'react';

import {getLayoutDataItemPropTypes} from '../../../prop-types/index';
import {switchSidebarPanel} from '../../actions/index';
import {LAYOUT_DATA_ITEM_TYPES} from '../../config/constants/layoutDataItemTypes';
import {config} from '../../config/index';
import {
	useHoverItem,
	useIsActive,
	useIsHovered,
	useSelectItem,
} from '../../contexts/ControlsContext';
import {useEditableProcessorUniqueId} from '../../contexts/EditableProcessorContext';
import {useDispatch, useSelector} from '../../contexts/StoreContext';
import selectCanUpdateItemConfiguration from '../../selectors/selectCanUpdateItemConfiguration';
import selectCanUpdatePageStructure from '../../selectors/selectCanUpdatePageStructure';
import selectSegmentsExperienceId from '../../selectors/selectSegmentsExperienceId';
import moveItem from '../../thunks/moveItem';
import {TARGET_POSITIONS} from '../../utils/drag-and-drop/constants/targetPositions';
import {
	useDragItem,
	useDropTarget,
} from '../../utils/drag-and-drop/useDragAndDrop';
import getLayoutDataItemLabel from '../../utils/getLayoutDataItemLabel';
import {useId} from '../../utils/useId';
import TopperItemActions from './TopperItemActions';
import {TopperLabel} from './TopperLabel';

const MemoizedTopperContent = React.memo(TopperContent);

export default function Topper({children, item, ...props}) {
	const canUpdatePageStructure = useSelector(selectCanUpdatePageStructure);
	const canUpdateItemConfiguration = useSelector(
		selectCanUpdateItemConfiguration
	);
	const isHovered = useIsHovered();
	const isActive = useIsActive();

	if (canUpdatePageStructure || canUpdateItemConfiguration) {
		return (
			<MemoizedTopperContent
				isActive={isActive(item.itemId)}
				isHovered={isHovered(item.itemId)}
				item={item}
				{...props}
			>
				{children}
			</MemoizedTopperContent>
		);
	}

	return children;
}

function TopperContent({
	children,
	className,
	isActive,
	isHovered,
	item,
	itemElement,
	style,
}) {
	const canUpdatePageStructure = useSelector(selectCanUpdatePageStructure);
	const commentsPanelId = config.sidebarPanels?.comments?.sidebarPanelId;
	const dispatch = useDispatch();
	const editableProcessorUniqueId = useEditableProcessorUniqueId();
	const fragmentEntryLinks = useSelector((state) => state.fragmentEntryLinks);
	const hoverItem = useHoverItem();
	const {isOverTarget, targetPosition, targetRef} = useDropTarget(item);
	const segmentsExperienceId = useSelector(selectSegmentsExperienceId);
	const selectItem = useSelectItem();
	const topperLabelId = useId();

	const canBeDragged = canUpdatePageStructure && !editableProcessorUniqueId;

	const name =
		getLayoutDataItemLabel(item, fragmentEntryLinks) ||
		Liferay.Language.get('element');

	const onDragEnd = (parentItemId, position) =>
		dispatch(
			moveItem({
				itemId: item.itemId,
				parentItemId,
				position,
				segmentsExperienceId,
			})
		);

	const {
		handlerRef: itemHandlerRef,
		isDraggingSource: itemIsDraggingSource,
	} = useDragItem({...item, name}, onDragEnd);

	const {
		handlerRef: topperHandlerRef,
		isDraggingSource: topperIsDraggingSource,
	} = useDragItem({...item, name}, onDragEnd);

	const isDraggingSource = itemIsDraggingSource || topperIsDraggingSource;

	return (
		<div
			aria-label={name}
			aria-labelledby={isActive ? topperLabelId : null}
			className={classNames(className, 'page-editor__topper', {
				'active': isActive,
				'drag-over-bottom':
					isOverTarget && targetPosition === TARGET_POSITIONS.BOTTOM,
				'drag-over-left':
					isOverTarget && targetPosition === TARGET_POSITIONS.LEFT,
				'drag-over-middle':
					isOverTarget && targetPosition === TARGET_POSITIONS.MIDDLE,
				'drag-over-right':
					isOverTarget && targetPosition === TARGET_POSITIONS.RIGHT,
				'drag-over-top':
					isOverTarget && targetPosition === TARGET_POSITIONS.TOP,
				'dragged': isDraggingSource,
				'hovered': isHovered,
			})}
			onClick={(event) => {
				event.stopPropagation();

				if (isDraggingSource) {
					return;
				}

				selectItem(item.itemId);
			}}
			onMouseLeave={(event) => {
				event.stopPropagation();

				if (isDraggingSource) {
					return;
				}

				if (isHovered) {
					hoverItem(null);
				}
			}}
			onMouseOver={(event) => {
				event.stopPropagation();

				if (isDraggingSource) {
					return;
				}

				hoverItem(item.itemId);
			}}
			ref={canBeDragged ? itemHandlerRef : null}
			style={style}
		>
			{isActive ? (
				<TopperLabel itemElement={itemElement}>
					<ul className="tbar-nav">
						{canBeDragged && (
							<li
								className="page-editor__topper__drag-handler page-editor__topper__item tbar-item"
								ref={topperHandlerRef}
							>
								<ClayIcon
									className="page-editor__topper__drag-icon page-editor__topper__icon"
									symbol="drag"
								/>
							</li>
						)}

						<li
							className="d-inline-block page-editor__topper__item page-editor__topper__title tbar-item tbar-item-expand"
							id={topperLabelId}
						>
							{name}
						</li>

						{item.type === LAYOUT_DATA_ITEM_TYPES.fragment && (
							<li className="page-editor__topper__item tbar-item">
								<ClayButton
									displayType="unstyled"
									small
									title={Liferay.Language.get('comments')}
								>
									<ClayIcon
										className="page-editor__topper__icon"
										onClick={() => {
											dispatch(
												switchSidebarPanel({
													sidebarOpen: true,
													sidebarPanelId: commentsPanelId,
												})
											);
										}}
										symbol="comments"
									/>
								</ClayButton>
							</li>
						)}

						{canUpdatePageStructure && isActive && (
							<li className="page-editor__topper__item tbar-item">
								<TopperItemActions item={item} />
							</li>
						)}
					</ul>
				</TopperLabel>
			) : null}

			<div className="page-editor__topper__content" ref={targetRef}>
				<TopperErrorBoundary>
					{React.cloneElement(children, {
						withinTopper: true,
					})}
				</TopperErrorBoundary>
			</div>
		</div>
	);
}

TopperContent.propTypes = {
	item: getLayoutDataItemPropTypes().isRequired,
	itemElement: PropTypes.object,
};

class TopperErrorBoundary extends React.Component {
	static getDerivedStateFromError(error) {
		if (process.env.NODE_ENV === 'development') {
			console.error(error);
		}

		return {error};
	}

	constructor(props) {
		super(props);

		this.state = {
			error: null,
		};
	}

	render() {
		return this.state.error ? (
			<ClayAlert
				displayType="danger"
				title={Liferay.Language.get('error')}
			>
				{Liferay.Language.get(
					'an-unexpected-error-occurred-while-rendering-this-item'
				)}
			</ClayAlert>
		) : (
			this.props.children
		);
	}
}
